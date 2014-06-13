/**
 * Created by aliang on 6/12/14.
 */
var tableLoader = (function () {
    var vTableID, vTable, vFields, vHeaders, vDefaultText, vDataExtractor;


    function createRowData(fields, data, isThead) {
        var rowData;
        var tag;

        if (isThead) {
            rowData = "<tr>"
            tag='th';
        } else {
            rowData = "<thead><tr>"
            tag='td';
        }


        if (fields && fields.length > 0) {
            $.each(fields, function (index, field) {
                    var finalData;
                    if (vDataExtractor) {
                        finalData = vDataExtractor(field, data);

                    } else {
                        finalData = data ? data[field + ''] : field;
                    }

                    rowData += '<'+tag+'>' + finalData + '</'+tag+'>';

                }
            );

        }

        if (isThead) {
            rowData = "</tr>"
        } else {
            rowData = "</tr></thead>"
        }

        return rowData;

    }


    function initializeHeaders() {
        vHeaders = (vHeaders == null || vHeaders.length < 1) ? vFields : vHeaders;
        var headers = createRowData(vHeaders,true);
        if (vTable.children('thead').length < 1)
            vTable.prepend('<thead></thead>');
        vTable.children('thead').html(headers);
    }

    function setNoData() {
        if (vTable.length < 1) return;
        var colspan = vHeaders && vHeaders.length > 0 ? 'colspan="' + vHeaders.length + '"' : '';
        var content = '<tr class="no-items"><td ' + colspan +
            ' style="text-align:center">' + vDefaultText + '</td></tr>';
        if (vTable.children('tbody').length > 0) {
            vTable.children('tbody').html(content);
        } else {
            vTable.append('<tbody>' + content + '</tbody>');
        }
    }


    return {

        initialize: function (tableID, fileds, headers, rowDataExtractor, defaultText) {
            vTableID = tableID;
            vTable = $('#' + tableID);
            vFields = fileds || null;
            vHeaders = headers || null;
            vDataExtractor = rowDataExtractor;
            vDefaultText = defaultText || 'No items to display';
            initializeHeaders();
            return this;
        },

        loadTableData: function (data, append) {
            if (vTable.length < 1) return;


            if (data && data.length > 0) {
                var rows = '';
                $.each(data, function (index, item) {
                    rows += createRowData(vFields, item);
                });


                if (vTable.children('tbody').length > 0) {
                    var method = append ? 'append' : 'html';
                    vTable.children('tbody')[method](rows);
                } else {
                    vTable.append('<tbody>' + rows + '</tbody>');

                }


            } else {
                setNoData();
            }
        }

    }


}());