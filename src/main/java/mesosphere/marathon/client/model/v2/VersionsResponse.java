package mesosphere.marathon.client.model.v2;

import java.util.List;
import mesosphere.marathon.client.utils.ModelUtils;

/**
 * @author Bruce Lee <bruce_lee@condenast.com>
 */
public class VersionsResponse {
  private List<String> versions;

  @Override
  public String toString() {
    return ModelUtils.toString(this);
  }

  public List<String> getVersions() {
    return versions;
  }

  public void setVersions(List<String> versions) {
    this.versions = versions;
  }
}
