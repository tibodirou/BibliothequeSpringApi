/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpContext } from '@angular/common/http';
import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';
import { RequestBuilder } from '../request-builder';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

import { Livre } from '../models/livre';

@Injectable({
  providedIn: 'root',
})
export class ApiService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation livreGet
   */
  static readonly LivreGetPath = '/livre';

  /**
   * Get all books.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `livreGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  livreGet$Response(params?: {
    context?: HttpContext
  }
): Observable<StrictHttpResponse<Array<Livre>>> {

    const rb = new RequestBuilder(this.rootUrl, ApiService.LivreGetPath, 'get');
    if (params) {
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<Array<Livre>>;
      })
    );
  }

  /**
   * Get all books.
   *
   *
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `livreGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  livreGet(params?: {
    context?: HttpContext
  }
): Observable<Array<Livre>> {

    return this.livreGet$Response(params).pipe(
      map((r: StrictHttpResponse<Array<Livre>>) => r.body as Array<Livre>)
    );
  }

  /**
   * Path part for operation livrePost
   */
  static readonly LivrePostPath = '/livre';

  /**
   * Ajout d'un nouveau livre.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `livrePost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  livrePost$Response(params: {
    context?: HttpContext

    /**
     * Livre à créer
     */
    body: Livre
  }
): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, ApiService.LivrePostPath, 'post');
    if (params) {
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'text',
      accept: '*/*',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
      })
    );
  }

  /**
   * Ajout d'un nouveau livre.
   *
   *
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `livrePost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  livrePost(params: {
    context?: HttpContext

    /**
     * Livre à créer
     */
    body: Livre
  }
): Observable<void> {

    return this.livrePost$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

  /**
   * Path part for operation livreIdGet
   */
  static readonly LivreIdGetPath = '/livre/{id}';

  /**
   * Get livre by id.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `livreIdGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  livreIdGet$Response(params: {

    /**
     * id of the book
     */
    id: number;
    context?: HttpContext
  }
): Observable<StrictHttpResponse<Livre>> {

    const rb = new RequestBuilder(this.rootUrl, ApiService.LivreIdGetPath, 'get');
    if (params) {
      rb.path('id', params.id, {});
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<Livre>;
      })
    );
  }

  /**
   * Get livre by id.
   *
   *
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `livreIdGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  livreIdGet(params: {

    /**
     * id of the book
     */
    id: number;
    context?: HttpContext
  }
): Observable<Livre> {

    return this.livreIdGet$Response(params).pipe(
      map((r: StrictHttpResponse<Livre>) => r.body as Livre)
    );
  }

  /**
   * Path part for operation livreIdPut
   */
  static readonly LivreIdPutPath = '/livre/{id}';

  /**
   * Modifier livre.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `livreIdPut()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  livreIdPut$Response(params: {

    /**
     * id of the book
     */
    id: number;
    context?: HttpContext
    body: Livre
  }
): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, ApiService.LivreIdPutPath, 'put');
    if (params) {
      rb.path('id', params.id, {});
      rb.body(params.body, 'application/json');
    }

    return this.http.request(rb.build({
      responseType: 'text',
      accept: '*/*',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
      })
    );
  }

  /**
   * Modifier livre.
   *
   *
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `livreIdPut$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  livreIdPut(params: {

    /**
     * id of the book
     */
    id: number;
    context?: HttpContext
    body: Livre
  }
): Observable<void> {

    return this.livreIdPut$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

  /**
   * Path part for operation livreIdDelete
   */
  static readonly LivreIdDeletePath = '/livre/{id}';

  /**
   * Delete livre by id.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `livreIdDelete()` instead.
   *
   * This method doesn't expect any request body.
   */
  livreIdDelete$Response(params: {

    /**
     * id of the book
     */
    id: number;
    context?: HttpContext
  }
): Observable<StrictHttpResponse<void>> {

    const rb = new RequestBuilder(this.rootUrl, ApiService.LivreIdDeletePath, 'delete');
    if (params) {
      rb.path('id', params.id, {});
    }

    return this.http.request(rb.build({
      responseType: 'text',
      accept: '*/*',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
      })
    );
  }

  /**
   * Delete livre by id.
   *
   *
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `livreIdDelete$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  livreIdDelete(params: {

    /**
     * id of the book
     */
    id: number;
    context?: HttpContext
  }
): Observable<void> {

    return this.livreIdDelete$Response(params).pipe(
      map((r: StrictHttpResponse<void>) => r.body as void)
    );
  }

}
