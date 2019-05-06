package pl.writeonly.re.shared.llvm.regex
import java.io.File

import scala.io.Source

import scalaz.Scalaz._

object Dir {
  def getLinesFromFile(file: File): Iterator[String] =
    (file |> Source.fromFile) getLines ()

  def filesFromDir(dirName: String): List[File] =
    dirName |> (new File(_)) |> filesFromDir

  def filesFromDir(dir: File): List[File] =
    if (dir.exists && dir.isDirectory) {
      dir.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }

  def linesFromDir(dirName: String): List[String] =
    (dirName |> filesFromDir) flatMap getLinesFromFile
}
