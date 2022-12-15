package me.deadorfd.downloader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import me.deadorfd.downloader.utils.Utils;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

/**
 * @Author DeaDorfd
 * @Project downloader
 * @Package me.deadorfd.downloader
 * @Date 02.12.2022
 * @Time 10:21:29
 */
public class Downloader extends JFrame {

	private JPanel contentPane;
	private JTextField stringurl;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Downloader frame = new Downloader();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Downloader() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		stringurl = new JTextField();
		stringurl.setBounds(162, 52, 180, 28);
		contentPane.add(stringurl);
		stringurl.setColumns(10);

		JLabel urlLabel = new JLabel("URL:");
		urlLabel.setLabelFor(stringurl);
		urlLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 18));
		urlLabel.setHorizontalAlignment(SwingConstants.CENTER);
		urlLabel.setBounds(66, 52, 86, 25);
		contentPane.add(urlLabel);

		JLabel titel = new JLabel("Downloader");
		titel.setFont(new Font("Source Serif Pro Black", Font.BOLD, 20));
		titel.setHorizontalAlignment(SwingConstants.CENTER);
		titel.setBounds(66, 11, 276, 14);
		contentPane.add(titel);

		JButton downloadbutton = new JButton("Download");
		downloadbutton.setFont(new Font("Source Serif Pro Black", Font.BOLD, 20));
		downloadbutton.setBounds(66, 186, 276, 23);
		downloadbutton.addActionListener(event -> {
			if (!stringurl.getText().equals("")) {
				boolean isSuccess = Utils.downloadFile(stringurl.getText());
				if (isSuccess) {
					stringurl.setText(null);
					int i = JOptionPane.showConfirmDialog(null,
							"The file was downloaded successfully! \nDo you want to open them too?", "successfully",
							JOptionPane.YES_NO_OPTION);
					if (i == 0) {
						try {
							Desktop.getDesktop().open(new File(Utils.downloadedfilename));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Der Download ist fehlgeschlafen!", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Die URL darf nicht leer sein!", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			}
		});
		contentPane.add(downloadbutton);
	}
}
