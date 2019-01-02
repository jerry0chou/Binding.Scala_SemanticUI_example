package app

import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.dom
import org.scalajs.dom.html.Input
import org.scalajs.dom.raw.Event


object View
{
  val input = Var("")
  @dom
  def render =
  {
    <div>
      <div class="ui selection dropdown">
        <input type="hidden" name="gender"  onchange={ event: Event => input.value= event.currentTarget.asInstanceOf[Input].value }/>
        <i class="dropdown icon"></i>
        <div class="default text">Gender</div>
        <div class="menu">
          <div class="item" data:data-value="Male">Male</div>
          <div class="item" data:data-value="Female">Female</div>
        </div>
      </div>
      the selected value is { input.bind }
    </div>
  }
}
