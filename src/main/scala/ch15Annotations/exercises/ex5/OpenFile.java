package ch15Annotations.exercises.ex5;

import java.io.IOException;

public class OpenFile {
    public static void main(String[] args) throws IOException {
        String str = GetFile.getStr("theory");
        System.out.println(str);
    }
}
