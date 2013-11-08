import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Song")
@XmlType(propOrder = { "singer", "songname", "album", "length" })
public class Song {

  private String singer;
  private String songname;
  private String album;
  private int length;

  @XmlElement(name = "title")

public String getSinger() {
	return singer;
}
public void setSinger(String singer) {
	this.singer = singer;
}
public String getSongname() {
	return songname;
}
public void setSongname(String songname) {
	this.songname = songname;
}
public String getAlbum() {
	return album;
}
public void setAlbum(String album) {
	this.album = album;
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}

} 