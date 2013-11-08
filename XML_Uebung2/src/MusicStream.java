import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class MusicStream {


  @XmlElementWrapper(name = "musicstream")

  @XmlElement(name = "song")
  private ArrayList<Song> songlist;
  private String name;
  
  
public ArrayList<Song> getSonglist() {
	return songlist;
}
public void setSonglist(ArrayList<Song> songlist) {
	this.songlist = songlist;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

} 