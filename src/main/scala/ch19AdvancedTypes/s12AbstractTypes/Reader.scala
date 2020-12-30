package ch19AdvancedTypes.s12AbstractTypes

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import scala.io.Source

trait Reader {
    type Contents
    def read(fileName: String): Contents
    //Here, the type Contents is abstract. A concrete subclass needs to specify the type
}

class StringReader extends Reader {
    type Contents = String
    def read(fileName: String) = Source.fromFile(fileName, "UTF-8").mkString
}
class ImageReader extends Reader {
    type Contents = BufferedImage
    def read(fileName: String) = ImageIO.read(new File(fileName))
}
