package net.gwaii.enums;

public enum ServerType {
    LOBBY, ARCHIVE;

//    Redundant right now, but will be useful when more enums added (groupings)
    public boolean isLobby() {
        return this.equals(ServerType.LOBBY);
    }
}
