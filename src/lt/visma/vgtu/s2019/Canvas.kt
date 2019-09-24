package lt.visma.vgtu.s2019

import java.awt.Graphics
import java.awt.Image

class Canvas (private val graphics: Graphics,
              private val map: Map,
              private val elementSize: Int){

    var offsetX = 0
    var offsetY = elementSize

    private var entities: Entities? = null

    fun draw(){
        for (y in 0 until map.height) {
            for (x in 0 until map.width) {
                val image = getImage(Position(x, y))
                if (image != null)
                    drawElement(image, x, y)
            }
        }
    }

    private fun drawElement(image: Image, x: Int, y: Int){
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
            Element.Wall -> map.wallImage
            Element.Ghost -> entities?.ghost!!.image
            Element.Pacman -> entities?.pacman!!.image
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