package lt.visma.vgtu.s2019

import java.awt.Image
import java.awt.image.BufferedImage

class ElementImageRepresentationImpl : ElementRepresentation<Image, BufferedImage> {

    private var image: BufferedImage? = null

    override fun getImage(): Image = image!!

    override fun setImage(image: BufferedImage){
        this.image = image
    }

}