package com.home.hryhoryeu.imagehandler.managers.impl;

import com.home.hryhoryeu.imagehandler.entities.ImageData;
import com.home.hryhoryeu.imagehandler.entities.PixelData;
import com.home.hryhoryeu.imagehandler.managers.IImageManager;
import com.home.hryhoryeu.imagehandler.ui.FullSizeImageScene;
import com.home.hryhoryeu.imagehandler.utils.converters.PixelDataConverter;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageManagerImpl implements IImageManager {

    private ImageData imageData;
    private FullSizeImageScene fullSizeImageScene;

    public ImageManagerImpl() {
        this.imageData = ImageData.getInstance();
        this.fullSizeImageScene = new FullSizeImageScene();
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Image image = new Image(url);

        imageData.setImageView(imageView);

        imageData.setSourceImageWidth((int)image.getWidth());
        imageData.setSourceImageHeight((int)image.getHeight());

        imageData.setSourceImage(image);
        imageData.setSourceImagePixelMap(pixelMapBuilder(getImageData().getSourceImage()));

        imageData.getImageStack().clear();
        setChangedImage(image);
        applyChangedImage(image);
    }

    @Override
    public void setChangedImage(Image image) {
        imageData.setChangedImage(image);
    }

    @Override
    public void applyChangedImage(Image image) {
        imageData.getImageStack().push(imageData.getChangedImage());
        imageData.setChangedImageWidth((int)image.getWidth());
        imageData.setChangedImageHeight((int)image.getHeight());
        imageData.setChangedImagePixelMap(pixelMapBuilder(image));
        calcBrightValues();
    }

    @Override
    public void saveChangedImage() {
        // TODO temp. refactoring
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(new Stage());

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(imageData.getChangedImage(), null),
                    "jpeg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ImageData getImageData() {
        return imageData;
    }

    @Override
    public Image back() {
        Image image;
        if (imageData.getImageStack().empty())
            image = imageData.getSourceImage();
        else image = imageData.getImageStack().pop();

        setChangedImage(image);
        recoveryImage(image);
        return image;
    }

    private void recoveryImage(Image image) {
        imageData.setChangedImageWidth((int)image.getWidth());
        imageData.setChangedImageHeight((int)image.getHeight());
        imageData.setChangedImagePixelMap(pixelMapBuilder(image));
        calcBrightValues();
    }

    @Override
    public void showSourceFullSizeImage() {
        fullSizeImageScene.buildFullSizeScene(imageData.getSourceImage());
    }

    @Override
    public void showChangedFullSizeImage() {
        fullSizeImageScene.buildFullSizeScene(imageData.getChangedImage());
    }

    private PixelData[][] pixelMapBuilder(Image image) {
        PixelData[][] pixelMap = new PixelData[(int)image.getWidth()][(int)image.getHeight()];
        for(int y = 0; y < (int)image.getHeight(); y++) {
            for(int x = 0; x < (int)image.getWidth(); x++) {
                pixelMap[x][y] = PixelDataConverter.toPixelData(image.getPixelReader().getColor(x, y), x, y);
            }
        }
        return pixelMap;
    }

    private void calcBrightValues() {
        PixelData pixelMap[][] = imageData.getChangedImagePixelMap();
        for(int y = 0; y < imageData.getSourceImageHeight(); y++) {
            for(int x = 0; x < imageData.getSourceImageWidth(); x++) {

                if (imageData.getMaxBrightness() < pixelMap[x][y].getBrightness())
                    imageData.setMaxBrightness(pixelMap[x][y].getBrightness());
                if (imageData.getMinBrightness() > pixelMap[x][y].getBrightness())
                    imageData.setMinBrightness(pixelMap[x][y].getBrightness());

                if (imageData.getMaxR() < pixelMap[x][y].getR())
                    imageData.setMaxR(pixelMap[x][y].getR());
                if (imageData.getMinR() > pixelMap[x][y].getR())
                    imageData.setMinR(pixelMap[x][y].getR());

                if (imageData.getMaxG() < pixelMap[x][y].getG())
                    imageData.setMaxG(pixelMap[x][y].getG());
                if (imageData.getMinG() > pixelMap[x][y].getG())
                    imageData.setMinG(pixelMap[x][y].getG());

                if (imageData.getMaxB() < pixelMap[x][y].getB())
                    imageData.setMaxB(pixelMap[x][y].getB());
                if (imageData.getMinB() > pixelMap[x][y].getB())
                    imageData.setMinB(pixelMap[x][y].getB());
            }
        }
    }
}