package com.exo.memory;

import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Jeu {

	private ImageIcon[][] figures = loadImages();

	public Jeu() throws IOException {
	}

	public ImageIcon[][] loadImages() throws IOException {
		int rows = 4;
		int cols = 3;

		ImageIcon[][] images = ResourceUtility
				.splitImageIcon(ResourceUtility.loadBufferedImage("images/butterfly2.png"), rows, cols);

		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				images[i][j].setDescription("c" + index++);
			}
		}

		return images;
	}

	public static void main(String[] args) throws IOException {

	}

	public Deque<ImageIcon> creerPioche() {
		LinkedList<ImageIcon> cartes = new LinkedList<>();

		int rows = figures.length;
		int cols = figures[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cartes.add(figures[i][j]);
				cartes.add(figures[i][j]);
			}

		}
		Collections.shuffle(cartes);
		return cartes;
	}

	/**
	 * public Deque<ImageIcon> creerPioche() { LinkedList<ImageIcon> list = new
	 * LinkedList<ImageIcon>(); for (int i = 0; i < 2; i++) { for (int row = 0; row
	 * <= 3; row++) { for (int col = 0; col <= 2; col++) {
	 * list.push(figures[row][col]); } } } Collections.shuffle(list); return list;
	 *
	 * }
	 *
	 */

}
