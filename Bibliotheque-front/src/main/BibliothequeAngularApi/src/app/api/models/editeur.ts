/* tslint:disable */
/* eslint-disable */
import { Livre } from './livre';

/**
 * Un editeur
 */
export interface Editeur {
  livres?: Array<Livre>;
  name?: string;
}
