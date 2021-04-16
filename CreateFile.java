package com.tyss.jdbc.staticinsert;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {
		File file= new File("G:\\FileHandlingtyss\\Prop.properties");
		boolean bool = false;
		try {
			bool = file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bool);

	}

}
