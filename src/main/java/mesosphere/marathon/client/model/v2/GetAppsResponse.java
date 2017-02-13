package mesosphere.marathon.client.model.v2;

import java.util.List;

import mesosphere.client.common.ModelUtils;

public class GetAppsResponse {
	private List<AppWithVersion> apps;

	public List<AppWithVersion> getApps() {
		return apps;
	}

	public void setApps(List<AppWithVersion> apps) {
		this.apps = apps;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}

}
