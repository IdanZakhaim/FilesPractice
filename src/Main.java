import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
           classExercise();
        Student student = new Student(1, "Idan");
        File file = createBinaryFile();
        writeToBinaryFile(file, student);
        readFromBinaryFile(file);
    }


    public static void classExercise() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String path = new String("C:\\Users\\Lenovo\\IdeaProjects\\FilesPractice\\Score.txt");
        File file = createFile(path);
        int userScore;
        try {
            while (true) {
                userScore = readFromFile(file);
                System.out.println("The score is :" + userScore);
                int num1 = random.nextInt(20);
                int num2 = random.nextInt(20);
                System.out.println(num1 + " + " + num2 + " = ?");

                int result = scanner.nextInt();
                if (result == num1 + num2) {
                    userScore += 1;
                } else userScore -= 3;
                writeToFile(file, userScore);
                readFromFile(file);

            }
        } catch (InputMismatchException e) {
            System.out.println("Value not number!");
        }
    }


    public static File createFile(String path) {
        File file = new File(path);
        try {
            boolean success = file.createNewFile();
            if (success) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file");
            e.printStackTrace();
        }
        return file;
    }


    public static void writeToFile(File file, int userScore) {
        try {
            if (file != null && file.exists()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(String.valueOf(userScore));
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readFromFile(File file) {
        int userScore = 0;
        if (file != null && file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String fileUserScore = bufferedReader.readLine();
                if (fileUserScore != null && fileUserScore.length() > 0) {
                    userScore = Integer.parseInt(fileUserScore);
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return userScore;
    }

    public static class Student implements Serializable {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "The student name is " + name + " id is " + id;
        }
    }


    public static File createBinaryFile() {
        String path = "C:\\Users\\Lenovo\\IdeaProjects\\FilesPractice\\binary.bin";
        File file = new File(path);
        try {
            boolean success = file.createNewFile();
            if (success) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Failed create file!");
        }
        return file;
    }


    public static void writeToBinaryFile(File file, Student student) {
        try {
            if (file != null && file.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(student);
                objectOutputStream.close();
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromBinaryFile(File file) {
        Student student = null;
        if (file != null && file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);// לוקח מהקובץ, לשים לב ל input
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);// לוקח את האובייקט
                student = (Student) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                System.out.println(student);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

            public static void studentsGrades () {
                Scanner scanner = new Scanner(System.in);
                File fileStudentGrades = new File("C:\\Users\\Lenovo\\IdeaProjects\\FilesPractice\\StudentsGrades.txt");
                try {
                    boolean success = fileStudentGrades.createNewFile();
                    if (success) {
                        System.out.println("The file was created successfully");
                    } else System.out.println("The file already exists");

                    if (fileStudentGrades != null && fileStudentGrades.exists()) {
                        FileReader fileReader = new FileReader(fileStudentGrades);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = null;
                        do {
                            line = bufferedReader.readLine();
                            if (line != null) System.out.println(line);
                        } while (line != null);
                        bufferedReader.close();
                        fileReader.close();
                    }

                    HashMap<String, Integer> exercises = new HashMap<>();
                    exercises.put("3+2=", 5);
                    exercises.put("5+4=", 9);
                    exercises.put("8+2=", 10);

                    System.out.println("Answer the following exercises: ");
                    int result = 0;
                    int answer = 0;
                    for (String exercise : exercises.keySet()) {
                        System.out.println(exercise);
                        System.out.println("Enter your answer: ");
                        try {
                            answer = scanner.nextInt();

                            if (answer == exercises.get(exercise)) {
                                result++;
                            } else {
                                result -= 3;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    String finalResult = String.valueOf(result);
                    if (fileStudentGrades != null && fileStudentGrades.exists()) {
                        FileWriter fileWriter = new FileWriter(fileStudentGrades);
                        fileWriter.write(finalResult);
                        fileWriter.close();
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }



//        File file = new File("C:\\Users\\Lenovo\\OneDrive\\שולחן העבודה\\תואר\\מונחה עצמים\\מצגות שי\\2023\\Idan.txt");
//        int userScore = readScore(file);
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//        while (true) {
//            System.out.println("The score is: " + userScore);
//            try {
//                int num1 = random.nextInt(20);
//                int num2 = random.nextInt(20);
//                System.out.println(num1 + " + " + num2 + " = ?");
//                int result = scanner.nextInt();
//                boolean rightAnswer  =result == num1 + num2;
//                if (rightAnswer) {
//                    userScore++;
//                } else {
//                    userScore -= 3;
//                }
//                saveScore(file, userScore);
//            } catch (Exception e) {
//                System.out.println("You must enter numbers only" + "\n" +
//                        "Try again");
//                scanner.nextInt();
//            }
//        }
//    }
//
//    public static int readScore(File file) {
//        int result = 0;
//        if (file != null && file.exists()) {
//            try {
//                FileReader fileReader = new FileReader(file);
//                BufferedReader bufferedReader = new BufferedReader(fileReader);
//                String text = bufferedReader.readLine();
//                if (text != null && text.length() > 0) {
//                    result = Integer.parseInt(text);
//                }
//                bufferedReader.close();
//                fileReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//            return result;
//        }
//
//    public static void saveScore (File file, int score){
//        if (file != null && file.exists()){
//            try {
//                FileWriter fileWriter = new FileWriter(file);
//                fileWriter.write(String.valueOf(score));
//                fileWriter.close();
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//            }
//    }