package game;

import java.util.HashMap;
import java.util.Random;

public class game {
	
	private HashMap<String, String[]> letters = new HashMap<String, String[]>();

	public void buildField(int height, int width){
		String[][] field = new String[height][width];
		String[] list = new String[height*width];
		for(int i = 0; i <= (height*width)/2; i++){
			Random r = new Random();
			char c = (char) (r.nextInt(26) + 'a');
			list[i] = ""+c;
		}
		for(int i = 0; i < height; i++){
			System.arraycopy(list, (i*width), field[i], 0, width);
		}
		System.out.println(list[5]);
		System.out.println(field[1][1]);
	}
	
	public void initHashMap(){
		letters.put("A", new String[]{"Error"});
		letters.put("B", new String[]{"Error"});
		letters.put("C", new String[]{"Error"});
		letters.put("D", new String[]{"Error"});
		letters.put("E", new String[]{"Error"});
		letters.put("F", new String[]{"Error"});
		letters.put("G", new String[]{"Error"});
		letters.put("H", new String[]{"Error"});
		letters.put("I", new String[]{"Error"});
		letters.put("J", new String[]{"Error"});
		letters.put("K", new String[]{"Error"});
		letters.put("L", new String[]{"Error"});
		letters.put("M", new String[]{"Error"});
		letters.put("N", new String[]{"Error"});
		letters.put("O", new String[]{"Error"});
		letters.put("P", new String[]{"Error"});
		letters.put("Q", new String[]{"Error"});
		letters.put("R", new String[]{"Error"});
		letters.put("S", new String[]{"Error"});
		letters.put("T", new String[]{"Error"});
		letters.put("U", new String[]{"Error"});
		letters.put("V", new String[]{"Error"});
		letters.put("W", new String[]{"Error"});
		letters.put("X", new String[]{"Error"});
		letters.put("Y", new String[]{"Error"});
		letters.put("Z", new String[]{"Error"});
	}
	
	public HashMap<String, String[]> getLetters() {
		return letters;
	}

	public void setLetters(HashMap<String, String[]> letters) {
		this.letters = letters;
	}
	
	public static void main(String[] args){
		game g = new game();
		g.buildField(4, 4);
	}
	
}
