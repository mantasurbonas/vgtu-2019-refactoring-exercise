package lt.visma.vgtu.s2019

interface ElementRepresentation <T, K> {
    fun getImage(): T
    fun setImage(image: K)
}