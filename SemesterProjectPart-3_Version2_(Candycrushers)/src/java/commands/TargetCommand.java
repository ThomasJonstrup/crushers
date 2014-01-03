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
public class TargetCommand implements Command { // Implementerer Command interfacet

    private final String target; // Hvor den skal sendes hen
    private final SecurityRole role; // sikkerhedsrolle, som bestemmes i securityRole enum

    public SecurityRole getRole() {
        return role;
    }

    public TargetCommand(String target, SecurityRole role) { // Konstruktør
        this.target = target;
        this.role = role;
    }

    @Override
    public String execute(HttpServletRequest request) { // execute metode, som er i command interfacet
        return target;
    }
}
