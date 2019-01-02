package app
import scala.scalajs.js
import org.querki.jquery.JQuery

// SemanticUI 的隐式转换
object SemanticUI
{
  @js.native
  trait SemanticJQuery extends JQuery {
    def dropdown(params: js.Any*): SemanticJQuery = js.native
  }
  implicit def jq2semantic(jq: JQuery): SemanticJQuery = jq.asInstanceOf[SemanticJQuery]
}
