/**
 * Created by ikanshyn on 15-03-19.
 */

var path = window.location.href;
if (window.location.href.indexOf("/Forms/Document%20Set/docsethomepage.aspx") > -1 ||
    window.location.href.indexOf("/Forms/AllItems.aspx") > -1) {
    console.log('our page. path = ' + path);

    function customizeFilesView(partualsId) {

        // =============================== Document Set ===============================

//        $('#scriptWPQ5 table#Hero-WPQ5').hide(); // File controllers
        $('#scriptWPQ' + partualsId + ' tr.ms-viewheadertr').hide(); // Table header
        $('#scriptWPQ' + partualsId + ' .ms-dragDropAttract').hide(); // message about adding files

        $('#scriptWPQ' + partualsId + ' .ms-list-itemLink-td').hide(); // a cell with three dots

        $('#scriptWPQ' + partualsId + ' .ms-vb-user').hide(); // a weird icon in front of a person's name

        $('#scriptWPQ' + partualsId + ' tr td.ms-vb-icon img').each(function( index ) {
            $(this).width(50); // change image size
            $(this).height(50); // change image size

            var imgSRC = $(this).attr("src");
            console.log("original SRC = "+imgSRC);

            if (imgSRC != undefined)
            {
                var urlsplit = imgSRC.split("/");
                var imageFile = urlsplit[urlsplit.length-1]; // last item that will be an image file name
                if (imageFile.indexOf("?") > 0)
                  imageFile = imageFile.substring(0, imageFile.indexOf("?"));
                console.log("imageFile = "+imageFile);

                switch (imageFile)
                {
                    case "icdocx.png":
                        $(this).attr("src", "/teams/BMOExecTeamSite/SiteAssets/Common/images/fileTypes/sp-big-icon-word.png");
                        break;
                    case "icxlsx.png":
                        $(this).attr("src", "/teams/BMOExecTeamSite/SiteAssets/Common/images/fileTypes/sp-big-icon-excel.png");
                        break;
                    case "icpdf.png":
                        $(this).attr("src", "/teams/BMOExecTeamSite/SiteAssets/Common/images/fileTypes/sp-big-icon-pdf.png");
                        break;
                    case "icpptx.png":
                        $(this).attr("src", "/teams/BMOExecTeamSite/SiteAssets/Common/images/fileTypes/sp-big-icon-powerPoint.png");
                        break;
                    case "icdocset.gif":
                    case "folder.gif":
                        $(this).attr("src", "/teams/BMOExecTeamSite/SiteAssets/Common/images/fileTypes/sp-big-icon-folder.png");
                        break;
                    case "icgen.gif":
                        $(this).attr("src", "/teams/BMOExecTeamSite/SiteAssets/Common/images/fileTypes/sp-big-icon-default.png");
                        break;
                    default:
                        $(this).attr("src", "/teams/BMOExecTeamSite/SiteAssets/Common/images/fileTypes/sp-big-icon-default.png");
                        break;
                }
            }

        });

        /*
         This is useful if we have an author's name
         $('#scriptWPQ5 .ms-vb-user .ms-imnSpan:first-child').hide(); // a weird icon in front of a person's name
         $('#scriptWPQ5 .ms-vb-user .ms-imnSpan').addClass('set-author'); // adding some space in front of a person's name

         */
        // Replace All Document and the search box
        $('#scriptWPQ' + partualsId + ' .ms-csrlistview-controldiv .ms-pivotControl-container .ms-pivotControl-overflowSpan').hide(); // three dots

        $('#scriptWPQ' + partualsId + ' #CSRListViewControlDivWPQ' + partualsId).hide(); // search box

        $('#scriptWPQ' + partualsId).prepend( "<div class='set-title'>Documents</div>" );

        var ii = 1;
        $("#scriptWPQ" + partualsId + " .ms-cellStyleNonEditable").each(function( index ) {
            $(this).html((ii++)+".");
        });


        $('#set-main-part').addClass('set-main-part');

        // Block arrangement
        $('#WebPartWPQ' + partualsId).addClass('set-fileDiv');

        // Create a title block with a folder name
        if (partualsId == 2)
        {
            $('#WebPartWPQ'+partualsId).addClass('set-main-part');

            var url = window.location.pathname;
            var urlsplit = url.split("/").slice(3,4);
            var folderName = decodeURIComponent(urlsplit[0]);
            //   console.log("urlsplit = "+decodeURIComponent(urlsplit[0]));

            $('#MSOZoneCell_WebPartWPQ2 > div').prepend( "<div id='set-top-part'><h2>"+folderName+"</h2></div>" );
        }

    }

    $(function () {
        console.log('started customization ...');

        $('#sideNavBox').hide(); // Navigation left panel
        $('#contentBox').css('margin-left', '0'); // moving the main area all the way to the left

        customizeFilesView(2);
        customizeFilesView(5);

        // Hide links in Document Set header
        $('#WebPartWPQ3 #ViewPropsLink').hide();
        $('#WebPartWPQ3 #EditPropsLink').hide();

    });

}

/*
<img width="16" height="16" border="0" alt="png File" title="BMO-Executive-v4_collapsed.png" id="imgIcon7WPQ2" src="/_layouts/15/images/icpng.gif" dragid="0" draggable="true" class=" ms-draggable">
<img width="16" height="16" border="0" alt="jpg File" title="Deva Premal. Mantras for Precarious Times.jpg" id="imgIcon5WPQ2" src="/_layouts/15/images/icjpg.gif" dragid="4" draggable="true" class=" ms-draggable">

<img width="16" height="16" border="0" alt="Word document" title="The second product.docx" id="imgIcon3WPQ2" src="/_layouts/15/images/icdocx.png" dragid="12" draggable="true" class=" ms-draggable">
<img width="16" height="16" border="0" alt="Excel workbook" title="Sales GDrive-SharePoint mapping.xlsx" id="imgIcon16WPQ2" src="/_layouts/15/images/icxlsx.png" style="width: 50px; height: 50px;" dragid="12" draggable="true" class=" ms-draggable">
*/