import java.util.ArrayList;

class Playlist {

	public static void main(String[] args) {
		ArrayList<String> desertIslandPlaylist = new ArrayList<String>();
		desertIslandPlaylist.add("D.D.");
		desertIslandPlaylist.add("one heart");
		desertIslandPlaylist.add("This is love...");
		desertIslandPlaylist.add("Movin' up");
		desertIslandPlaylist.add("Sugar");
		desertIslandPlaylist.add("Grandeur");
		desertIslandPlaylist.add("Juicy");
		System.out.println(desertIslandPlaylist);
		System.out.println(desertIslandPlaylist.size());
		desertIslandPlaylist.remove(3);
		desertIslandPlaylist.remove(5);
		System.out.println(desertIslandPlaylist.size());
		System.out.println(desertIslandPlaylist);
		int indexA = desertIslandPlaylist.indexOf("D.D.");
		int indexB = desertIslandPlaylist.indexOf("This is love...");
		String tempA = "D.D.";
		desertIslandPlaylist.set(indexA, "This is love...");
		desertIslandPlaylist.set(indexB, tempA);
		System.out.println(desertIslandPlaylist);
	}
}