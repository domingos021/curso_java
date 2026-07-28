package instrucoes;

/**
 * Reference guide for Git commands, ordered by daily usage frequency.
 * Designed to serve as a quick cheat sheet in your IDE.
 */
public class ComandosGit {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("      GIT CHEAT SHEET - FREQUENCY OF USE          ");
        System.out.println("==================================================");

        /*
         * 1. DAILY ESSENTIALS (Usados várias vezes ao dia)
         * The core cycle of saving, checking status, and syncing changes.
         */

        // Check the current state of working directory and staging area
        String status = "git status";

        // Add all modified and new files to the staging area
        String addAll = "git add .";

        // Add a specific file to the staging area
        String addFile = "git add path/to/File.java";
        /*
         Add a specific file to the staging area
         Example: Staging only the InserirDados.java file instead of all changes
        String addFile = "git add src/main/java/demo_inserir_dados/InserirDados.java";
         */

        // Record staged changes into the local repository with a descriptive message
        String commit = "git commit -m \"feat: description of changes\"";

        // Push local commits to the remote repository (GitHub)
        String push = "git push";

        // Fetch and merge changes from the remote repository to keep local updated
        String pull = "git pull";


        /*
         * 2. HISTORY & INSPECTION (Usados diariamente para checar o progresso)
         * Inspecting commits and understanding code changes.
         */

        // Display a simplified, one-line-per-commit history
        String logOneLine = "git log --oneline";

        // Display full commit history with author, date, and detailed messages
        String log = "git log";

        // Show differences between working directory and staging area / last commit
        String diff = "git diff";


        /*
         * 3. QUICK FIXES & AMENDS (Usados frequentemente para pequenos ajustes)
         * Fixing minor errors before or right after committing.
         */

        // Update the last commit message or add forgotten staged files to it
        String commitAmend = "git commit --amend -m \"updated commit message\"";

        // Unstage a file without losing local edits
        String restoreStaged = "git restore --staged path/to/File.java";

        // Discard local changes in a file (revert back to the last commit)
        String restoreFile = "git restore path/to/File.java";


        /*
         * 4. BRANCHING & FEATURE MANAGEMENT (Usados ao iniciar novas tarefas)
         * Isolating features, bugfixes, and switching contexts.
         */

        // Create a new branch and immediately switch to it
        String checkoutNew = "git checkout -b feature/new-feature";

        // Switch to an existing branch
        String checkout = "git checkout main";

        // List all local branches
        String branchList = "git branch";

        // Merge changes from specified branch into the current branch
        String merge = "git merge feature/new-feature";


        /*
         * 5. HISTORY REWRITING & RESETS (Usados ocasionalmente / Emergências)
         * Undoing commits and resolving repository mismatches.
         */

        // Undo the last commit while KEEPING all file modifications staged/unstaged
        String resetSoft = "git reset --soft HEAD~1";

        // Safely force push local commits after rewriting history (e.g., reset/amend)
        String pushForce = "git push --force-with-lease";

        // DESTRUCTIVE: Undo the last commit and DISCARD all changes made in it
        String resetHard = "git reset --hard HEAD~1";


        /*
         * 6. SETUP & INITIALIZATION (Usados apenas no início de um projeto ou máquina)
         * One-time or rare configuration commands.
         */

        // Clone an existing remote repository onto your machine
        String clone = "git clone https://github.com/user/repository.git";

        // Initialize a new local Git repository in the current folder
        String init = "git init";

        // Set global Git username
        String configUser = "git config --global user.name \"Your Name\"";

        // Set global Git email
        String configEmail = "git config --global user.email \"your-email@gmail.com\"";

        // Link local repository to a remote repository URL
        String addRemote = "git remote add origin https://github.com/user/repository.git";


        // Print daily core workflow as a reminder
        System.out.println("\nStandard Daily Cycle:");
        System.out.println("1. " + status);
        System.out.println("2. " + addAll);
        System.out.println("3. " + commit);
        System.out.println("4. " + push);
    }
}