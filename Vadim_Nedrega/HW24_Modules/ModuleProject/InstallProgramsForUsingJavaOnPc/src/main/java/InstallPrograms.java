import Program.Git.Git64;
import Program.IDEA.IDEA64;
import Program.JDK.JDK64;
import Program.Program;

import java.util.Locale;

public class InstallPrograms implements InstallForWindows64<Program> {
    public static void main(String[] args) {
        InstallPrograms installPrograms = new InstallPrograms();

        Git64 git64 = new Git64();
        IDEA64 idea64 = new IDEA64();
        JDK64 jdk64 = new JDK64();

        installPrograms.installGit(git64);
        installPrograms.installIdea(idea64);
        installPrograms.installJDK(jdk64);
    }

    OperationSystem operationSystem = new Windows64("Windows 10 Enterprise");

    @Override
    public void installGit(Program program) {
        System.out.println("GIT for " + operationSystem.getName().toUpperCase(Locale.ROOT) + " had been installed");
    }

    @Override
    public void installJDK(Program program) {
        System.out.println("JDK for " + operationSystem.getName().toUpperCase() + " had been installed");

    }

    @Override
    public void installIdea(Program program) {
        System.out.println("IDEA for " + operationSystem.getName().toUpperCase(Locale.ROOT) + " had been installed");

    }
}
