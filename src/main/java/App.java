import com.google.gson.JsonElement;
import models.GithubRepository;
import models.Snapshot;
import services.GitHubMinerService;

import java.io.File;
import java.io.IOException;

/**
 * Created by salizumberi-laptop on 29.12.2016.
 */
public class App {

    private final static String GITAPI = "https://api.github.com/";
    private final static String REPOS = "repos/";

    public static void main(String[] args) throws Exception {
/*
        String repoName = args[0];
        String dockerPath = args[1];
*/

        String repoName = "seapy/slack_invite_automation_sinatra";
        String dockerPath = "Dockerfile";

        GithubRepository gitHubMetaData = GitHubMinerService.getGitHubRepository(GITAPI + REPOS + repoName);

        String repoFolderName = REPOS + String.valueOf(gitHubMetaData.id);
        String repoFolderNameDotGit = repoFolderName + "\\.git";

        GitCloner gitCloner = new GitCloner();
        System.out.println("2. Clone Repo");
        gitCloner.cloneRepository(gitHubMetaData.git_url, repoFolderName);

        String currentDirectory = new File("").getAbsolutePath() + "\\" + repoFolderName;
        File dockerfile  = new File(currentDirectory+ "\\" +dockerPath+ "Dockerfile");
        File flatDockerFile  = new File(currentDirectory+ "\\" +"FlatDockerfile");
        flatDockerFile.createNewFile();
        System.out.println(dockerfile.exists());
        System.out.println(flatDockerFile.exists());

        DockerParser dockerParser = new DockerParser(repoFolderName, dockerPath);
        Snapshot dockerfileSnapshot = dockerParser.getDockerfileObject();

        JsonElement json = JsonPrinter.getJsonObject(dockerfileSnapshot, String.valueOf(gitHubMetaData.id));
        System.out.println(JsonPrinter.getJsonString(json));
    }

    public static Snapshot getDockerFile(String localPath, String dockerPath, String filename) throws IOException {
        DockerParser dockerParser = new DockerParser(localPath, dockerPath);
        Snapshot dockerfileSnapshot;
        if (filename == null) {
            dockerfileSnapshot = dockerParser.getDockerfileObject();
        } else {
            dockerfileSnapshot = dockerParser.getDockerfileObject(filename);
        }

        // System.out.println(dockerParser.toString());
        return dockerfileSnapshot;
    }
}
