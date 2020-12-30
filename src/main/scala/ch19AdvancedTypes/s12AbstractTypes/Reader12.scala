package ch19AdvancedTypes.s12AbstractTypes

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import scala.io.Source
// The same effect could be achieved with a type parameter
trait Reader12[C] {
    def read(fileName: String): C
}
class StringReader12 extends Reader12[String] {
    def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
}
class ImageReader12 extends Reader12[BufferedImage] {
    def read(fileName: String) = ImageIO.read(new File(fileName))
}