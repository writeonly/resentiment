//package pl.writeonly.re.shared.llvm

//object Tabulator {
//  private val Pipe = "|"
//  private val Plus = "+"
//
//  def format(table: Seq[Seq[Any]]): String = table match {
//    case Seq() => ""
//    case _     => formatSave(table)
//  }
//
//  private def formatSave(table: Seq[Seq[Any]]): String = {
//    val sizes = table.map(_.map(length))
//    val colSizes = sizes.transpose.map(_.max)
//    val rows = table.map(row => formatRow(row, colSizes))
//    formatRows(rowSeparator(colSizes), rows)
//  }
//
//  def formatRows(rowSeparator: String, rows: Seq[String]): String = (
//    rowSeparator ::
//      rows.head ::
//      rowSeparator ::
//      rows.tail.toList :::
//      rowSeparator ::
//      List()).mkString("\n")
//
//  def formatRow(row: Seq[Any], colSizes: Seq[Int]): String = row
//    .zip(colSizes)
//    .map(t => cell(t._1, t._2))
//    .mkString(Pipe, Pipe, Pipe)
//
//
//  private def rowSeparator(colSizes: Seq[Int]): String = colSizes
//    .map("-" * _)
//    .mkString(Plus, Plus, Plus)
//
//  private def length(item: Any): Int = Option(item)
//    .map(_.toString.length)
//    .getOrElse(0)
//
//  private def cell(item: Any, size: Int)= if (size == 0) "" else ("%" + size.toString + "s").format(item)
//}
