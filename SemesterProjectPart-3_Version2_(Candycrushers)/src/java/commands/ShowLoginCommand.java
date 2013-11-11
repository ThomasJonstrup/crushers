/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import security.SecurityRole;

/**
 *
 * @author Thomas
 */
public class ShowLoginCommand extends TargetCommand {

    public ShowLoginCommand(String target, SecurityRole role) {
        super(target, role);
    }
    
}
