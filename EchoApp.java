package ktbyte.assistant.app.echo;

import java.util.List;

import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.App;

public class EchoApp extends App {

	@Override
	public List<Action> getActions() {
		// TODO Auto-generated method stub
		return List.of(new EchoAction());
	}

}
