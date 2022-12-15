package me.deadorfd.downloader.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * @Author DeaDorfd
 * @Project downloader
 * @Package me.deadorfd.downloader.utils
 * @Date 02.12.2022
 * @Time 10:27:59
 */
public class Utils {

	public static String downloadedfilename = null;

	public static boolean downloadFile(String stringurl) {
		URL url = null;
		String name = "Test100.mp4";
		try {
			url = new URL(stringurl);
			name = FilenameUtils.getName(url.getPath()).replaceAll("%20", " ");
		} catch (MalformedURLException e1) {}
		try {
			if (!name.contains(".php")) {
				FileUtils.copyURLToFile(url, new File("C:\\Users\\domin\\Desktop\\Musik export/" + name));
				downloadedfilename = "C:\\Users\\domin\\Desktop\\Musik export/" + name;
				return true;
			} else {
				JOptionPane.showMessageDialog(null, ".php Dateien sind auf der Blacklist", "Fehler",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (IOException e) {}
		return false;
	}

	public static void sendMessage(Object object) {
		System.out.println(object);
	}

}
