package MazeSolver;

import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.util.*;
import java.io.*;
import java.util.Scanner;

public class MazeAnimator extends Application {
    private boolean pathUpdated = false;
    private boolean solvingStopped = false;
    private Timeline timeline;
    private int[] current_node;
    private boolean solving = false;
    private Stage stage;
    private int solver_count = 0;

    private Cell[][] maze;
    private MazeGenerator Maze;
    public static boolean solver_called = false;
    public String file_name = "maze.txt";
    public final int button_size = 100;

    public void start(Stage stage) {
        this.stage = stage;
        maze_gen_screen();
    }



    public void maze_gen_screen() {

        FlowPane root2 = new FlowPane();
        root2.setPadding(new javafx.geometry.Insets(20));
        root2.setHgap(10);
        root2.setVgap(10);

        javafx.scene.control.Button btn3 = new javafx.scene.control.Button();
        btn3.setText("Confirm");
        javafx.scene.control.TextField text = new javafx.scene.control.TextField();
        javafx.scene.control.Label label = new javafx.scene.control.Label();
        label.setText("Enter Size");

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean maze_finished = false;
                int[] start = {0, 0};
                Maze = new MazeGenerator(Integer.parseInt(text.getText()), start);
                maze = Maze.maze;

                while (!maze_finished) {
                    try {
                        maze_finished = Maze.generate();
                    } catch (Exception ex) {
                    }
                }

                maze = Maze.maze;
                try {
                    maze_page();
                } catch (Exception ex) {
                }
            }
        });

        javafx.scene.control.Button btn_back = new javafx.scene.control.Button();
        btn_back.setText("Back");


        root2.getChildren().removeAll();
        root2.getChildren().addAll(label, text, btn3, btn_back);
        stage.setScene(new Scene(root2, 300, 250));
        stage.show(
        );
    }


    public void maze_page() throws FileNotFoundException {
        double TIME_DELAY = .05;
        int width = 400;
        int length = 400;
        Scanner file = new Scanner(new FileReader(file_name));
        int lines = 0;
        int longest_line = 0;
        while (file.hasNext()) {
            lines++;
            String temp = file.nextLine();
            if (temp.length() > longest_line)
                longest_line = temp.length();
        }

        file = new Scanner(new FileReader(file_name));
        int current_line = 1;

        FlowPane root = new FlowPane();
        root.setPadding(new javafx.geometry.Insets(20));
        root.setHgap(10);
        root.setVgap(10);

        Group g = new Group();
        Scene scene = new Scene(root, width, length);

        while (file.hasNext()) {
            String temp = file.nextLine();
            String[] chars = temp.split("");

            for (int i = 0; i < chars.length; i++) {
                if (chars[i].equals("-")) {
                    javafx.scene.shape.Rectangle r = new javafx.scene.shape.Rectangle();
                    r.setX((width - button_size) * (double) (i) / chars.length);
                    r.setY((length - button_size) * (double) current_line / lines - 2);
                    r.setWidth((width - button_size) * 1.0 / chars.length);
                    r.setHeight(2);
                    r.setFill(javafx.scene.paint.Color.RED);
                    g.getChildren().add(r);

                } else if (chars[i].equals("|")) {

                    javafx.scene.shape.Rectangle r = new javafx.scene.shape.Rectangle();
                    if (i == chars.length - 1)
                        r.setX((width - button_size) * (double) (i + 1) / chars.length - 2);
                    else
                        r.setX((width - button_size) * (double) (i) / chars.length);
                    r.setY((length - button_size) * (double) current_line / lines);
                    r.setWidth(2);
                    r.setHeight((length - button_size) * 1.0 / lines);
                    g.getChildren().add(r);
                    javafx.scene.shape.Rectangle r2 = new javafx.scene.shape.Rectangle();

                    if (i == chars.length - 1)
                        r2.setX((width - button_size) * (double) (i + 1) / chars.length - 2);
                    else
                        r2.setX((width - button_size) * (double) (i) / chars.length);
                    r2.setY((length - button_size) * (current_line - 1.0) / lines);
                    r2.setWidth(2);
                    r2.setHeight((length - button_size) * 1.0 / lines);
                    g.getChildren().add(r2);
                } else if (chars[i].equals("4")) {
                    javafx.scene.shape.Rectangle r = new Rectangle();
                    r.setX((width - button_size) * (double) (i) / chars.length + ((width - button_size) * 1.0 / chars.length) / 2);
                    r.setY((length - button_size) * (double) (current_line - 1) / lines - 2 + ((length - button_size) * 1.0 / lines));
                    r.setWidth(4);
                    r.setHeight(4);
                    r.setFill(Color.GREEN);
                    g.getChildren().add(r);
                }
            }
            current_line++;
        }

        javafx.scene.control.Button btn_solve = new javafx.scene.control.Button();
        btn_solve.setText("Solve");
        btn_solve.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                solve_maze();
            }
        });

        javafx.scene.control.Button btn_back = new javafx.scene.control.Button();
        btn_back.setText("Back");
        btn_back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                solver_called = false;
                solvingStopped = false;
                MazeAnimator temp = new MazeAnimator();

                temp.stage = stage;
                temp.maze_gen_screen();

            }
        });

        if (solving && !pathUpdated && !solvingStopped) {
            timeline = new Timeline(
                    new KeyFrame(Duration.seconds(TIME_DELAY), e -> {
                        if (!solvingStopped) {
                            try {
                                maze[current_node[0]][current_node[1]].setWallCode(5);
                                current_node = animate_solution(current_node);
                                maze[current_node[0]][current_node[1]].setWallCode(4);
                                /*Rectangle r = new Rectangle();
                                r.setX((width - button_size) * (double) (current_node[1] * 3 + 1) / (maze.length * 3) + ((width - button_size) * 1.0 / (maze.length * 3)) / 2);
                                r.setY((length - button_size) * (double) (2 * current_node[0] + 1) / (maze.length * 2 + 1) - 2 + ((length - button_size) * 1.0 / (maze.length * 2 + 1)));
                                r.setWidth(4);
                                r.setHeight(4);
                                r.setFill(Color.GREEN);
                                g.getChildren().add(r);*/
                                pathUpdated = true;
                                maze_page();

                                if (current_node == null || current_node[0] == Maze.end_point()[0] && current_node[1] == Maze.end_point()[1]) {
                                    solvingStopped = true;
                                    timeline.stop();
                                    MazeAnimator temp = new MazeAnimator();
                                    temp.stage = stage;
                                    temp.maze_page();
                                    return;

                                }
                            } catch (Exception ex) {
                                return;
                            }
                        }
                    }));
            timeline.setAutoReverse(true);
            timeline.setCycleCount(solver_count*2);
            timeline.play();
        }
        else
            pathUpdated =false;
        if (solvingStopped)
            timeline.stop();

        if (solver_called) {
            root.getChildren().addAll(g, btn_back);
        } else
            root.getChildren().addAll(g, btn_solve, btn_back);

        stage.setTitle("Maze");

        stage.setScene(scene);

        stage.show();
    }

    public void solve_maze() {
        if (!solver_called) {
            MazeSolver solver = new MazeSolver();
            solver.solve(maze);
            start_animation();
        }
    }

    public void start_animation() {
        if (!solvingStopped) {
            solving = true;

            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    if (maze[i][j].getWallCode() == 2)
                        solver_count++;
                }
            }

            current_node = Maze.startPoint();
            maze[current_node[0]][current_node[1]].setWallCode(4);

            try {
                Maze.writeMazeASCII(maze);
                maze_page();

            } catch (Exception ex) {
            }
        }
    }

    public int[] animate_solution(int[] current_node) {
        if (!solvingStopped) {
            Cell temp = maze[current_node[0]][current_node[1]].next_node();
            try {
                current_node[0] = temp.horizontalNode;
                current_node[1] = temp.verticalNode;
            } catch (Exception ex) {
            }

            maze[current_node[0]][current_node[1]].setWallCode( 4);
            try {
                Maze.writeMazeASCII(maze);
            } catch (Exception ex) {
            }

            return current_node;
        }
        return null;
    }

    public static void main(String args[]) {
        Application.launch(args);
    }


}
