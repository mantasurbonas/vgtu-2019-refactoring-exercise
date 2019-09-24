package lt.visma.vgtu.s2019

import java.awt.Graphics
import java.awt.Image

class Canvas (private val map: Map,
              private val elementSize: Int){

    //The numbers vary by system, MacOS should use X - 0, Y - elementSize, Windows is weird
    var offsetX = elementSize / 2
    var offsetY = elementSize + 15

    private var entities: Entities? = null

    fun draw(graphics: Graphics){
        for (y in 0 until map.height) {
            for (x in 0 until map.width) {
                val image = getImage(Position(x, y))
                if (image != null)
                    drawElement(image, x, y, graphics)
            }
        }
    }

    private fun drawElement(image: Image, x: Int, y: Int, graphics: Graphics){
        graphics.drawImage(
                image,
                offsetX + x * elementSize,
                offsetY + y * elementSize,
                elementSize,
                elementSize,
                null)
    }

    private fun getImage(position: Position): Image?{
        return when(getElementOnPosition(position)){
            Element.Wall -> map.wallImage.getImage() as Image
            Element.Ghost -> entities?.ghost!!.image.getImage() as Image
            Element.Pacman -> entities?.pacman!!.image.getImage() as Image
            Element.Air -> null
        }
    }

    private fun getElementOnPosition(position: Position): Element{
        if (entities?.pacman!!.position?.x == position.x && entities?.pacman!!.position?.y == position.y)
            return Element.Pacman
        if (entities?.ghost!!.position?.x == position.x && entities?.ghost!!.position?.y == position.y)
            return Element.Ghost
        if (map.getMapElement(position) == 0)
            return Element.Air
        if (map.getMapElement(position) == 1)
            return Element.Wall
        return Element.Air
    }

    data class Entities(
            var pacman: Pacman,
            var ghost: Ghost
    )

    fun loadEntities(entities: Entities){
        this.entities = entities
    }
}