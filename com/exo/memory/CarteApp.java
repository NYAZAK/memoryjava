package com.exo.memory;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Deque;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class CarteApp extends FrameForDemoMaker {

	private static final int ROW_COUNT = 4;
	private static final int COLUMN_COUNT = 6;

	private Jeu jeu = new Jeu();

	EtatMemoire etatMemoire = new EtatMemoire();

	private ImageIcon dosCarte = ResourceUtility.loadImage("images/dos.png");

	public CarteApp() throws IOException {
		super("Mémoire");
		setDefaultBounds(100, 100, 900, 600);
	}

	@Override
	public void init(JFrame frame) {
		Container cp = frame.getContentPane();
		// cp.add(createButton());

		cp.setLayout(new GridLayout(ROW_COUNT, COLUMN_COUNT));
		Deque<ImageIcon> pioche = jeu.creerPioche();
		while (!pioche.isEmpty()) {
			cp.add(createButton(pioche.pop()));
		}

		/*
		 * for (int i = 0; i < ROW_COUNT; i++) { for (int j = 0; j < COLUMN_COUNT; j++)
		 * { cp.add(createButton()); } }
		 */
	}

	/*
	 * public JComponent createButton(Deque<ImageIcon> pioche) {
	 *
	 * ImageIcon imageIcon = pioche.pop(); // Récupération depuis la pioche final
	 * JToggleButton button = new JToggleButton(imageIcon);
	 * button.putClientProperty("carte", imageIcon.getDescription());
	 *
	 * button.addActionListener(new ActionListener() {
	 *
	 * @Override public void actionPerformed(ActionEvent e) {
	 * System.out.println(button.getClientProperty("carte")); } });
	 *
	 * return button; }
	 */

	public JComponent createButton(ImageIcon imageIcon) {

		final JToggleButton button = new JToggleButton(dosCarte);
		button.setSelectedIcon(imageIcon);
		button.setDisabledIcon(imageIcon);
		button.setDisabledSelectedIcon(imageIcon);
		button.putClientProperty("carte", imageIcon.getDescription());

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(button.getClientProperty("carte"));
				etatMemoire.nouveauBoutonSelectionne(button);
			}
		});

		return button;
	}

	public static void main(String[] args) throws IOException {
		CarteApp example = new CarteApp();
		SwingUtilities.invokeLater(example);
	}
}
