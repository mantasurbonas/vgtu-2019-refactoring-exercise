package lt.visma.vgtu.s2019

class ElementLetterRepresentationImpl : ElementRepresentation<Char, Char> {

    private var letter: Char? = null

    override fun getImage(): Char = letter!!

    override fun setImage(image: Char) {
        letter = image
    }
}