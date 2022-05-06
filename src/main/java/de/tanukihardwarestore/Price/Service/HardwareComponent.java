package de.tanukihardwarestore.Price.Service;

public class HardwareComponent {

    private float uvp;



    public HardwareComponent() { }

    public HardwareComponent(Long id, String type, String model, String manufacturer, float uvp, String description,
                             String releaseDate, float weight, String productName, long ean, String imageURL) {
        this.uvp = uvp;
    }

    public HardwareComponent(float uvp) {
        this.uvp = uvp;
    }

    public float getUvp() {
        return uvp;
    }

}
