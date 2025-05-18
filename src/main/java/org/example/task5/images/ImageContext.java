package org.example.task5.images;

public class ImageContext {

    ImageResolvingStrategy resolvingStrategy;

    public ImageContext() {
    }

    public void setResolvingStrategy(ImageResolvingStrategy resolvingStrategy) {
        this.resolvingStrategy = resolvingStrategy;
    }

    public String executeStrategy(String imageName) {
        return resolvingStrategy.getImage(imageName);
    }
}
