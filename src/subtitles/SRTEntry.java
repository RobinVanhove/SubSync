package subtitles;

import main.Util;

class SRTEntry {

	private long from, to;
	private String text;

	public SRTEntry(long from, long to, String text) {
		this.setFrom(from);
		this.setTo(to);
		this.setText(text);
	}

	public SRTEntry(String from, String to, String text) {
		this(Util.stringToTimestamp(from), Util.stringToTimestamp(to), text);
	}

	@Override
	public String toString() {
		String str = this.getFromAsString() + " --> " + this.getToAsString() + "\r\n" + this.getText();
		return str;
	}

	public long getFrom() {
		return this.from;
	}

	public void setFrom(long from) {
		this.from = from;
	}

	public String getFromAsString() {
		return Util.timestampToString(this.getFrom());
	}

	public long getTo() {
		return this.to;
	}

	public void setTo(long to) {
		this.to = to;
	}

	public String getToAsString() {
		return Util.timestampToString(this.getTo());
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

}
