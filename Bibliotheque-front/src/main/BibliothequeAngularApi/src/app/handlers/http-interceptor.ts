import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, finalize, Observable, retry, throwError } from "rxjs";
import { NotificationService } from "../services/notification-service";

@Injectable()
export class CustomHttpInterceptor implements HttpInterceptor {

    constructor(private notificationService : NotificationService){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // TODO: Impl goes here
        const hardcodedToken = 'abcd';
        const reqWithAuth = req.clone({
            setHeaders: {
                Authorization: `Bearer ${hardcodedToken}`
            }
        });
        return next.handle(req)
            .pipe(
                //retry(2),

                catchError((error: HttpErrorResponse) => {
                    //this.openSnackBar("Connection à la base de données impossible", "OK");

                    let errorMessage = '';

                    if (error.error instanceof ErrorEvent) {
                        // client-side error
                        errorMessage = `Error Status: ${error.status}\nMessage: ${error.message}`;

                    }
                    else {
                        // server-side error
                        errorMessage = this.handleServerSideError(error)
                    }

                    this.notificationService.openSnackBar(errorMessage, "OK");

                    return throwError(() => new Error(errorMessage))
                }),

                finalize(() => {
                    const profilingMsg = `${req.method} "${req.urlWithParams}"`;
                    console.log(profilingMsg);
                })
            )
    }


    private handleServerSideError(error: HttpErrorResponse): string {

        let errorMessage = '';

        switch (error.status) {
            case 400:
                errorMessage = `Error: ${error.error}`
                break;
            case 401:
                errorMessage = `Error: ${error.error}`
                break;
            case 403:
                errorMessage = `Error: ${error.error}`
                break;
            default:
                errorMessage = "Connection à la base de données impossible";
        }
        return errorMessage;
    }
}
