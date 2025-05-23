/*
    This file is part of the HeavenMS MapleStory Server, commands OdinMS-based
    Copyleft (L) 2016 - 2019 RonanLana

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
   @Author: Arthur L - Refactored command content into modules
*/
package client.command.commands.gm4;

import client.Character;
import client.Client;
import client.command.Command;
import tools.PacketCreator;

public class MobpointRateCommand extends Command {
    {
        setDescription("Set max mob per spawnpoint rate. (Should always be equal or higher than mob rate)");
    }

    @Override
    public void execute(Client c, String[] params) {
        Character player = c.getPlayer();
        if (params.length < 1) {
            player.yellowMessage("Syntax: !mobpoint <newrate>");
            player.yellowMessage("Current Mob Point Rate: " + c.getWorldServer().getMobperspawnpoint());
            return;
        }

        int maxmobperspawnpoint = Math.max(Integer.parseInt(params[0]), 1);
        c.getWorldServer().setMobperspawnpoint(maxmobperspawnpoint);
        c.getWorldServer().broadcastPacket(PacketCreator.serverNotice(6, "[Rate] Max Mob Per Spawnpoint Rate has been changed to " + maxmobperspawnpoint + "x."));
    }
}