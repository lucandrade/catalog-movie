package com.dromaskin.mc.tmdbentity;

public class MoviePoster {

	private String file_path;
	
	private int height;
	
	private int width;
	
	public String makeUrl(String url) {
		if (file_path != null) {
			return String.format("%sw%s%s", url, (width - (width % 100)), file_path);
		} else {
			return "";
		}
	}

	public String getFilePath() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
