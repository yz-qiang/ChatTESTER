package nl.pvanassen.ns;

import nl.pvanassen.ns.model.prijzen.Prijzen;

import java.text.SimpleDateFormat;
import java.util.Date;

class PrijzenRequest extends ApiRequest<Prijzen> {
    private final String from;
    private final String to;
    private final String via;
    private final Date dateTime;

    PrijzenRequest(String from, String to, String via, Date dateTime) {
        this.from = from;
        this.to = to;
        this.via = via;
        this.dateTime = dateTime;
    }

    /**
     * {@inheritDoc}
     * 
     * @see nl.pvanassen.ns.ApiRequest#getPath()
     */
    @Override
    String getPath() {
        return "ns-api-prijzen-v3";
    }

    /**
     * 
     * {@inheritDoc}
     * 
     * @see nl.pvanassen.ns.ApiRequest#getRequestString()
     */
    @Override
    String getRequestString() {
        StringBuilder requestString = new StringBuilder();
        requestString.append("from=").append(from).append('&');
        requestString.append("to=").append(to).append('&');
        if (via != null && via.trim().length() != 0) {
            requestString.append("via=").append(via).append('&');
        }
        if (dateTime != null) {
            requestString.append("date=").append(new SimpleDateFormat("ddMMyyyy").format(dateTime));
        }
        return requestString.toString();
    }

}
