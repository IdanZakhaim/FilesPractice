import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String path = new String("C:\\Users\\Lenovo\\IdeaProjects\\FilesPractice\\Score.txt");
        File file = createFile(path);
        int userScore;
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
            writeToFile(file,userScore);
            readFromFile(file);
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
        int userScore  = 0;
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
        }
        else
         {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return userScore;
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