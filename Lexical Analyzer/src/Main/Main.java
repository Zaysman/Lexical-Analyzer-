package Main;

//Libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static File file = new File("Plain Text"); //Our source file
	static List<String> list = new LinkedList<String>(); //The list we add our lexemes into


	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Scanner fromFile = new Scanner(file); //This scanner scans through input file
		String input = new String(); //This String holds each individual lexeme in the file

		String source = fromFile.nextLine();
		fromFile = new Scanner(file);
		
		while(fromFile.hasNext()) {
			input = fromFile.next();
			handleString(input);
		}

		fromFile.close();
		
		System.out.println("Input: " + source);
		clearEmptySpaces(list);
		printList(list);

	}


	public static void clearEmptySpaces(List list) {
		for(int i = 0; i < list.size(); i++) {
			String str = (String) list.get(i);
			if(str.isEmpty() == true) {
				list.remove(i);
			}

		}
	}

	public static void printList(List list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println("list(" + i + ")" + list.get(i));
		}
	}


	public static void handleString(String str) {
		if(hasSpecialCharacter(str) == false) {
			list.add(str);
		} else {
			spliceString(str);
		}


	}

	public static void spliceString(String str) {
		int special = specialCharacterAt(str);
		String substr = str.substring(0, special);
		list.add(substr);

		list.add(Character.toString(str.charAt(special)));
		substr = str.substring(special + 1, str.length());
		handleString(substr);
	}

	/*
	 * The purpose of this method is to determine if a special character exists within a string. If so, returns true. else returns false
	 * 
	 * str - String parameter
	 */

	public static boolean hasSpecialCharacter(String str) {

		for(int i = 0; i < str.length(); i++) {
			if(checkSpecialCharacter(str.charAt(i)) == true) {
				return true;
			}
		}

		return false;
	}


	/*
	 * Assuming a special character has been found within a string, this method finds and returns the index of the first special character found.
	 * 
	 * str - String parameter
	 */

	public static int specialCharacterAt(String str) {

		for(int i = 0; i < str.length(); i++) {
			if(checkSpecialCharacter(str.charAt(i)) == true) {
				return i;
			}
		}

		return -1;
	}

	/*
	 * method that check if the given character is a special character. if so, returns true. else returns false.
	 */

	public static boolean checkSpecialCharacter(char ch) {

		switch(ch) {
		case ';' :
		case '!' :
		case '#' :
		case '"' :
		case '$' :
		case '%' :
		case '&' :
		case '(' :
		case ')' :
		case '*' :
		case '+' :
		case ',' :
		case '-' :
		case '.' :
		case '/' :
		case ':' :
		case '<' :
		case '=' :
		case '>' :
		case '?' :
		case '@' :
		case '[' :
		case '\\' :
		case ']' :
		case '^' :
		case '_' :
		case '`' :
		case '{' :
		case '}' :
		case '|' :
		case '~' :	
			return true;
		default:
			return false;

		}
	}



}
