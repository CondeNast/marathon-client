package mesosphere.marathon.client.model.v2;

import mesosphere.marathon.client.utils.ModelUtils;

public class GetAppResponse {
	private AppWithVersion app;

	public AppWithVersion getApp() {
		return app;
	}

	public void setApp(AppWithVersion app) {
		this.app = app;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
