package com.coderscampus.lesson9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.coderscampus.lesson5.Person;

public class SerializableApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		savePeopleToFile();
		loadPeopleFromFile();

	}

	private static void loadPeopleFromFile() throws IOException, ClassNotFoundException {
		try (FileInputStream fileInput = new FileInputStream("people.txt");
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);) {
			Person dave = (Person)objectInput.readObject();
			Person jane = (Person)objectInput.readObject();
			Person elon = (Person)objectInput.readObject();
			System.out.println(dave.getName());
			System.out.println(jane.getName());
			System.out.println(elon.getName());

		}

	}

	private static void savePeopleToFile() throws IOException, FileNotFoundException {
		Person dave = new Person("Dave Naugler", 68);
		Person jane = new Person("Jane Doe", 65);
		Person elon = new Person("Elon Musk", 75);

		try (FileOutputStream fileOutput = new FileOutputStream("people.txt");
				ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
			objectOutput.writeObject(dave);
			objectOutput.writeObject(jane);
			objectOutput.writeObject(elon);
		}
	}

}
