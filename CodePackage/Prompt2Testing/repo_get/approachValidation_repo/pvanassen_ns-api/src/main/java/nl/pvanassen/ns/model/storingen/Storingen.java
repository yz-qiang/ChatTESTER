package nl.pvanassen.ns.model.storingen;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import nl.pvanassen.ns.model.NsResult;

import java.util.List;

/**
 * http://www.ns.nl/reisinformatie/ns-api/documentatie-storingen-en-werkzaamheden.html
 * 
 * @author Paul van Assen
 * 
 */
@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Storingen implements NsResult {
    private final List<Storing> ongeplandeStoringen;
    private final List<Storing> geplandeStoringen;
}
