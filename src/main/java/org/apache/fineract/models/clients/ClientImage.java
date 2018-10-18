package org.apache.fineract.models.clients;

import java.awt.image.BufferedImage;
import com.google.common.base.Preconditions;
public final class ClientImage {
	
	public enum Type {

        PNG("png"),
        JPEG("jpeg"),
        GIF("gif");

        private String type;

        Type(final String typeString) {
            this.type = typeString;
        }
        public String getTypeString() {
            return this.type;
        }

    }
	public static class Builder {

        private BufferedImage image;
        private Type type;

        private Builder(final BufferedImage clientImage) {
            this.image = clientImage;
        }

        /**
         * Sets the image type, that is, any one of 'png', 'jpg' or 'gif'.
         * @param imageType the image type
         * @return the current instance of {@link Builder}
         */
        public Builder type(final Type imageType) {
            Preconditions.checkNotNull(imageType);

            this.type = imageType;
            return this;
        }

        /**
         * Constructs a new ClientImage instance with the provided parameters.
         * @return a new instance of {@link ClientImage}
         */
        public ClientImage build() {
            Preconditions.checkNotNull(this.type);

            return new ClientImage(this.image, this.type);
        }

    }

    private BufferedImage image;
    private Type type;
    private Long resourceId;

    private ClientImage(final BufferedImage clientImage,
                        final Type imageType) {
        this.image = clientImage;
        this.type = imageType;
    }

    /**
     * Returns the image.
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * Returns the image type.
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Returns the resource ID if it exists, null otherwise.
     */
    public Long getResourceId() {
        return this.resourceId;
    }

    /**
     * Sets the resource ID of the image.
     * @param id the resource ID
     */
    public void setResourceId(final Long id) {
        Preconditions.checkNotNull(id);

        this.resourceId = id;
    }

    /**
     * Sets the image.
     * @param image a {@link BufferedImage}
     * @return a new instance of {@link Builder}
     */
    public static Builder image(final BufferedImage image) {
        Preconditions.checkNotNull(image);

        return new Builder(image);
    }

}
