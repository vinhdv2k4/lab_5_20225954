package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.Aim.Aims;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfArtist;
    private JTextField tfDirector;
    private JTextField tfCost;
    private JTextField tfNumberTracks;
    private int numberTracks;

    public AddCompactDiscToStoreScreen() {
        super("CD");
        JPanel center = createCenter();

        tfTitle = addInputField("Title: *", center);
        tfCategory = addInputField("Category:", center);
        tfArtist = addInputField("Artist", center);
        tfDirector = addInputField("Director:", center);
        tfCost = addInputField("Cost: *", center);
        tfNumberTracks = addInputField("Tracks: *", center);

        center.add(Box.createRigidArea(new Dimension(10, 20)));
        add(center, BorderLayout.CENTER);
        add(createSouth(new ButtonListener()), BorderLayout.SOUTH);

        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "OK": {
                    if (tfTitle.getText().trim().isEmpty() || tfCost.getText().trim().isEmpty()
                            || tfNumberTracks.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Some required fields are empty!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        String title = tfTitle.getText().trim();
                        String category = tfCategory.getText().trim();
                        String artist = tfArtist.getText().trim();
                        String director = tfDirector.getText().trim();
                        float cost = Float.parseFloat(tfCost.getText().trim());

                        if (cost <= 0) {
                            JOptionPane.showMessageDialog(null, "Cost must be greater than 0!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        CompactDisc cd = new CompactDisc(title, category, artist, director, cost);
                        numberTracks = Integer.parseInt(tfNumberTracks.getText().trim());

                        if (numberTracks <= 0) {
                            JOptionPane.showMessageDialog(null, "Number of tracks must be greater than 0!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        new AddTracksToCompactDiscScreen(cd);
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, "Cost and number of tracks must be numeric!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                    break;
                case "Cancel":
                    setVisible(false);
                    break;
            }
        }
    }

    private class AddTracksToCompactDiscScreen extends AddItemToStoreScreen {
        private CompactDisc cd;
        private JLabel lblTrackNo;
        private JTextField tfTitle;
        private JTextField tfLength;
        private int screenIndex;

        public AddTracksToCompactDiscScreen(CompactDisc cd) {
            super("Track");
            this.cd = cd;
            this.screenIndex = 1;

            JPanel center = createCenter();

            lblTrackNo = new JLabel("Track no. " + screenIndex);
            lblTrackNo.setAlignmentX(CENTER_ALIGNMENT);
            center.add(lblTrackNo);
            center.add(Box.createRigidArea(new Dimension(10, 20)));

            tfTitle = addInputField("Title: *", center);
            tfLength = addInputField("Length:", center);

            center.add(Box.createRigidArea(new Dimension(10, 120)));
            add(center, BorderLayout.CENTER);
            add(createSouth(new ButtonListener()), BorderLayout.SOUTH);

            setVisible(true);
        }

        private void reset() {
            tfTitle.setText("");
            tfLength.setText("");
            screenIndex++;
            lblTrackNo.setText("Track no. " + screenIndex);
            setVisible(true);
        }

        private class ButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "OK": {
                        if (tfTitle.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Required fields are empty!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        try {
                            String trackTitle = tfTitle.getText().trim();
                            int length = tfLength.getText().trim().isEmpty() ? 0 : Integer.parseInt(tfLength.getText().trim());

                            if (length < 0) {
                                JOptionPane.showMessageDialog(null, "Length must be a positive integer!", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            Track track = new Track(trackTitle, length);
                            cd.addTrack(track);
                            setVisible(false);

                            if (screenIndex == numberTracks) {
                                Aims.getStore().addMedia(cd);
                                Aims.getStoreScreen().loadItemsToStore();
                                AddCompactDiscToStoreScreen.this.setVisible(false);
                                JOptionPane.showMessageDialog(null, "New CD added to store!");
                                return;
                            }

                            reset();
                        } catch (NumberFormatException e1) {
                            JOptionPane.showMessageDialog(null, "Length must be an integer value!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                        break;
                    case "Cancel":
                        setVisible(false);
                        break;
                }
            }
        }
    }
}
