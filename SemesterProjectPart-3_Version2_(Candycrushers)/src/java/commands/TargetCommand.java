/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Thomas
 */
public class TargetCommand implements Command {

    private final String target;
    private final SecurityRole role;

    public SecurityRole getRole() {
        return role;
    }

    public TargetCommand(String target, SecurityRole role) {
        this.target = target;
        this.role = role;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return target;
    }
}
