package app

import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import org.querki.jquery.$
import scala.scalajs.js.Dynamic.literal
import SemanticUI.jq2semantic

import scala.scalajs.js.JSApp

object MainApp extends JSApp
{
  def main(): Unit =
  {
    dom.render(document.body, View.render)
    $(".ui.dropdown").dropdown(literal(on="hover",clearable= true))

  }
}
